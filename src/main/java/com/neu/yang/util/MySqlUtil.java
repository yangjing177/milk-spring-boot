package com.neu.yang.util;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MySqlUtil {

    /**
     * 2018/11/7 18:02
     * ycl
     * 连接数据库,将数据库所有表生成JavaBean
     * 使用即粘,用后就删,方便快捷,简约强大
     *
     * 使用方法
     *      0: 添加Maven依赖(如不使用lombok,则无需添加)
     *      1: 将MySqlUtil粘贴到包中(粘到哪里,JavaBean在哪里生成)
     *      2: 修改MySql的配置
     *      3: 执行main函数
     *

     * Maven依赖

     <dependency>
     <groupId>mysql</groupId>
     <artifactId>mysql-connector-java</artifactId>
     <version>5.1.32</version>
     </dependency>

     */

    /**
     * 注 : 1.只支持idea
     * 3.需要配置lombok(不配就要手动添加GET SET)
     * 若尚未配置 参考 https://jingyan.baidu.com/article/0a52e3f4e53ca1bf63ed725c.html
     */

    // MySql的配置
    private final String driver = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://127.0.0.1:3306/milk";
    private final String user = "root";
    private final String password = "root";


    //以下是为了更好的体验的辅助功能(如果不需要,就当做没看到)
    //========================================================================

    /**
     * 忽略数据库字段头
     * 忽略的字段头(表名: t_user, 可以设置 hand="t_", 这样javabean就会忽略t_)
     * 如果不全是以"t_"开头, 不是的则会被忽略
     * 如果出现这种 user, t_user, 后者会覆盖前者
     */
    private final String hand = "";

    /**
     * 指定生成表
     * (列: 生成user表, appoint = {"user"})
     * 注: 名字与数据库名字一致
     */
    private final String[] appoint = {"car"};

    // 时间转化格式(可自定义)
    private final String pattern = "yyyy-MM-dd HH:mm:ss";

    // 如果你不想生成的字段使用驼峰转化, 可以使ishump = false
    private final boolean ishump = true;

    // 如果你不想生成JavaBean, 仅仅想生成service/dao, 将isdomain = false;
    private final boolean isdomain = true;

    /**
     * 生成(dao/mapper)
     * 这里会在当前目录下创建一个dao文件夹, 生成mapper
     * 你也可以自定义这个文件夹的名字,这样复制会方便许多
     * 例(daopath = "com.czxy.bos.dao")
     */
    private final String daomkdir = "mapper";
    // 如果你不想生成dao, 将isdao = false;
    private final boolean isdao = true;

    /**
     * 生成(service)
     * 这里会在当前目录下创建一个servicemkdir文件夹, 生成service
     * 包含基本的增删改查
     * 你也可以自定义这个文件夹的名字,这样复制会方便许多
     * 例(daopath = "com.czxy.bos.dao")
     */
    private final String servicemkdir = "service";
    // 如果你不想生成service, 将isservice = false;
    private final boolean isservice = true;

    //================================================================================
    public static void main(String[] args) throws Exception {
        new MySqlUtil().start();
    }

    // 高级配置, 自定义生成的service, domain和自段对应的类型
    //===============================================================================
    // 生成service的模板
    private final String serviceMould = "" +
            "package servicePackageName;\n" +
            "\n" +
            "import org.springframework.stereotype.Service;\n" +
            "import org.springframework.transaction.annotation.Transactional;\n" +
            "import javax.annotation.Resource;\n" +
            "import java.util.List;\n" +
            "\n" +
            "import domainPackageName;\n" +
            "import mapperPackageName;\n" +
            "\n" +
            "@Service\n" +
            "@Transactional\n" +
            "public class ServiceName {\n" +
            "\n" +
            "    @Resource\n" +
            "    private MapperName mapperName;\n" +
            "\n" +
            "    /**\n" +
            "     * 添加\n" +
            "     * @param className\n" +
            "     */\n" +
            "    public void save(ClassName className){\n" +
            "        mapperName.insert(className);\n" +
            "    }\n" +
            "\n" +
            "    /**\n" +
            "     * 主键删除\n" +
            "     * @param id\n" +
            "     */\n" +
            "    public void delete(PrimaryKeyType id){\n" +
            "        mapperName.deleteByPrimaryKey(id);\n" +
            "    }\n" +
            "\n" +
            "    /**\n" +
            "     * 修改\n" +
            "     * @param className\n" +
            "     */\n" +
            "    public void update(ClassName className){\n" +
            "        mapperName.updateByPrimaryKey(className);\n" +
            "    }\n" +
            "\n" +
            "    /**\n" +
            "     * 查询所有\n" +
            "     * @return\n" +
            "     */\n" +
            "    public List<ClassName> findAll(){\n" +
            "        return mapperName.selectAll();\n" +
            "    }" +
            "\n" +
            "    /**\n" +
            "     * 查询\n" +
            "     * @return\n" +
            "     */\n" +
            "    public ClassName findById(PrimaryKeyType id){\n" +
            "        return mapperName.selectByPrimaryKey(id);\n" +
            "    }\n" +
            "}";

    // 生成domain的模板
    private final String domainMould = "" +
            "package domainPackageName;\n" +
            "\n" +
            "import lombok.Data;\n" +
            "import javax.persistence.Column;\n" +
            "import javax.persistence.Entity;\n" +
            "import javax.persistence.Id;\n" +
            "import javax.persistence.Table;\n" +
            "import java.sql.Timestamp;\n" +
            "import java.util.Date;\n" +
            "\n" +
            "@Entity\n" +
            "@Table(name = \"tableName\")\n" +
            "@Data\n" +
            "public class ClassName{";

    // Types数据类型转化
    // 可能的所有数据类型, 目前仅支持这几种
    // 如果有未知的数据类型, 默认Object
    // 你可以手动在此配置
    private final HashMap<String, String> map = new HashMap<String, String>() {
        {
            put("INT", "Integer");
            put("INT UNSIGNED", "Integer");
            put("VARCHAR", "String");
            put("CHAR", "String");
            put("DOUBLE", "Double");
            put("DATETIME", "Date");
            put("DATE", "Date");
            put("FLOAT", "Float");
            put("TIMESTAMP", "Timestamp");
            put("BIGINT", "Long");
            put("TEXT", "String");
            put("DECIMAL", "Double");
            put("LONGTEXT", "String");
            put("TINYINT UNSIGNED", "Integer");
        }
    };



    // 非专业人士不要在往下看了,大神请当做没看到这句话
    // ===============================================================================
    public void start() throws Exception {
        // 获取当前文件绝对路径
        // 生成包名
        // 注 : 此格式只适用于idea
        File f = new File(this.getClass().getResource("").getPath());
        String packageName = f.getPath().split("classes\\\\")[1].replace("\\", ".");
        // path为当前文件绝对路径
        String path = f.getPath().replace("target\\classes", "src\\main\\java");
        // 如果路径中有空格,idea会转成%,所以需要转回来
        path = path.replace("%", " ");

        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, user, password);
        // 获取所有表名
        ArrayList<String> tables = getTables(conn);

        // 如果配置了生成指定表, 将tables的数据替换
        // 如果配置的名字有错误(一定要和数据库一致), 会报错
        if (appoint.length > 0) {
            tables.clear();
            Collections.addAll(tables, appoint);
        }

        // 遍历所有需要获取的表
        for (String tableName : tables) {
            // 生成类名
            String ClassName = underline2Camel(hand != "" && tableName.startsWith(hand) ? tableName.substring(hand.length(), tableName.length()) : tableName, false);
            // 生成主键名
            String primarykey = null;
            // 主键类型
            String PrimaryKeyType = null;

            // 查询, 匹配主键名
            ResultSet resultSet = conn.getMetaData().getColumns(null, null, tableName.toUpperCase(), "%");
            ResultSet rs = conn.getMetaData().getPrimaryKeys(conn.getCatalog().toUpperCase(),
                    null, tableName.toUpperCase());
            while (rs.next()) {
                primarykey = rs.getString("COLUMN_NAME");
            }

            // 生成domain
            // 拼接文件内容
            StringBuffer sb = new StringBuffer();

            String str = domainMould;
            str = str.replace("domainPackageName", packageName);
            str = str.replace("tableName", tableName);
            str = str.replace("ClassName", ClassName);

            sb.append(str);
            System.out.println("\n表 " + tableName + " 生成类" + ClassName);

            // 获取列名
            while (resultSet.next()) {
                // resultSet数据下标从1开始
                sb.append("\r\n");
                String columnName = resultSet.getString("COLUMN_NAME");
                String typeName = map.get(resultSet.getString("TYPE_NAME"));
                String remarks = resultSet.getString("REMARKS");
                if (columnName.equals(primarykey)) {
                    sb.append("\r\n\t@Id");
                    PrimaryKeyType = typeName;
                }

                if (remarks != null && !"".equals(remarks)) {
                    sb.append("\r\n\t// " + remarks);
                }
                sb.append("\r\n\t@Column(name = \"" + columnName + "\")");
                if (typeName != null) {
                    System.out.print(columnName + "字段为" + typeName + "类型 " + "\t");
                    // 时间类型加上时间格式化
                    if (typeName.equals("Date")) {
                        sb.append("\r\n\t@DateTimeFormat(pattern = \"" + pattern + "\")");
                    }
                    sb.append("\r\n\tprivate " + typeName + " " + underline2Camel(columnName, ishump, ishump) + ";");
                } else {
                    System.out.println("\033[31;4m" + "未知类型 " + columnName + "数据库类型为" + resultSet.getString("TYPE_NAME") + "\033[0m");
                    sb.append("\r\n\tprivate Object " + underline2Camel(columnName, ishump, ishump) + ";");
                }
            }

            sb.append("\r\n}");
            System.out.println();
            // 生成文件
            if (isdomain) {
                File file = new File(path, ClassName + ".java");
                System.out.println("生成domain文件\t" + path + "/" + ClassName + ".java");
                if (file.exists()) {
                    file.delete();
                }
                FileOutputStream outputStream = new FileOutputStream(file);
                outputStream.write(sb.toString().getBytes());
                outputStream.close();
            }

            // 生成dao
            if (isdao) {
                File file2 = new File(path + "/" + daomkdir, ClassName + "Mapper.java");
                file2.mkdirs();
                System.out.println("生成mapper文件\t" + path + "/" + ClassName + "Mapper.java");
                if (file2.exists()) {
                    file2.delete();
                }
                StringBuffer sbdao = new StringBuffer();
                sbdao.append("package " + packageName + "." + daomkdir + ";\r\n\r\n");
                sbdao.append("import tk.mybatis.mapper.common.Mapper;\n");
                sbdao.append("import " + packageName + "." + ClassName + ";\n");
                sbdao.append("@org.apache.ibatis.annotations.Mapper\n");
                sbdao.append("public interface " + ClassName + "Mapper extends Mapper<" + ClassName + "> {}\n");
                FileOutputStream outputStream2 = new FileOutputStream(file2);
                outputStream2.write(sbdao.toString().getBytes());
                outputStream2.close();
            }

            // 生成service   如果没有主键, 不生成service
            if (isservice && PrimaryKeyType != null) {
                File file3 = new File(path + "/" + servicemkdir, ClassName + "Service.java");
                file3.mkdirs();
                System.out.println("生成service文件\t" + path + "/" + ClassName + "Service.java");
                if (file3.exists()) {
                    file3.delete();
                }
                String MapperName = ClassName + "Mapper";
                String mapperName = underline2Camel(ClassName) + "Mapper";
                String className = underline2Camel(ClassName);

                StringBuffer sbservice = new StringBuffer();
                String s = serviceMould;
                s = s.replace("servicePackageName", packageName + "." + servicemkdir);
                s = s.replace("domainPackageName", packageName + "." + ClassName);
                s = s.replace("mapperPackageName", packageName + "." + daomkdir + "." + MapperName);
                s = s.replace("ServiceName", ClassName + "Service");
                s = s.replace("MapperName", MapperName);
                s = s.replace("mapperName", mapperName);
                s = s.replace("ClassName", ClassName);
                s = s.replace("className", className);
                s = s.replace("PrimaryKeyType", PrimaryKeyType);
                sbservice.append(s);
                FileOutputStream outputStream3 = new FileOutputStream(file3);
                outputStream3.write(sbservice.toString().getBytes());
                outputStream3.close();
            }
        }
    }

    // 获取所有表名
    private static ArrayList<String> getTables(Connection conn) throws SQLException {
        DatabaseMetaData dbMetData = conn.getMetaData();
        ResultSet rs = dbMetData.getTables(null, convertDatabaseCharsetType("root", "mysql"), null, new String[]{"TABLE", "VIEW"});
        ArrayList<String> tableNames = new ArrayList<String>();
        while (rs.next()) {
            if (rs.getString(4) != null
                    && (rs.getString(4).equalsIgnoreCase("TABLE") || rs
                    .getString(4).equalsIgnoreCase("VIEW"))) {
                String tableName = rs.getString(3).toLowerCase();
                tableNames.add(tableName);
            }
        }
        return tableNames;
    }

    public static String convertDatabaseCharsetType(String in, String type) {
        String dbUser;
        if (in != null) {
            if (type.equals("oracle")) {
                dbUser = in.toUpperCase();
            } else if (type.equals("postgresql")) {
                dbUser = "public";
            } else if (type.equals("mysql")) {
                dbUser = null;
            } else if (type.equals("mssqlserver")) {
                dbUser = null;
            } else if (type.equals("db2")) {
                dbUser = in.toUpperCase();
            } else {
                dbUser = in;
            }
        } else {
            dbUser = "public";
        }
        return dbUser;
    }

    /**
     * 下划线转驼峰法(默认小驼峰)
     *
     * @param line       源字符串
     * @param smallCamel 大小驼峰,是否为小驼峰(驼峰，第一个字符是大写还是小写)
     * @return 转换后的字符串
     */
    public static String underline2Camel(String line, boolean... smallCamel) {
        if (line == null || "".equals(line)) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("([A-Za-z\\d]+)(_)?");
        Matcher matcher = pattern.matcher(line);

        if (smallCamel.length == 2 && !smallCamel[0] && !smallCamel[1]){
            return line;
        }
        //匹配正则表达式
        while (matcher.find()) {
            String word = matcher.group();
            //当是true 或则是空的情况
            if ((smallCamel.length == 0 || smallCamel[0]) && matcher.start() == 0) {
                sb.append(Character.toLowerCase(word.charAt(0)));
            } else {
                sb.append(Character.toUpperCase(word.charAt(0)));
            }

            int index = word.lastIndexOf('_');
            if (index > 0) {
                sb.append(word.substring(1, index).toLowerCase());
            } else {
                sb.append(word.substring(1).toLowerCase());
            }
        }
        return sb.toString();
    }

}

