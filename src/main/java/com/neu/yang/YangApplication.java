package com.neu.yang;

import com.alibaba.fastjson.JSON;
import com.neu.yang.model.JsonRootBean;
import com.neu.yang.model.Table;
import freemarker.template.Template;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
//@RestController
////
@MapperScan("com.neu.yang.dao")
@ServletComponentScan
public class YangApplication {



////    private static final String PATH = "C:\\Users\\yang\\Desktop\\数据库定义\\本地数据源";
////    private static final String PATH = "C:\\Users\\yang\\Desktop\\数据库定义\\portal_dev";
//    private static final String PATH = "C:\\Users\\yang\\Desktop\\数据库定义\\uc_dev";
//
    public static void main(String[] args) throws Exception {
        SpringApplication.run(YangApplication.class, args);
    }
///**
// * 1、遍历所有文件
// * 2、读取文件中的文本内容
// * 3、使用JSON库，将读取的文本内容反序列化为指定类型的Java对象
// * 4、使用Java对象和模板引擎，生成SQL语句。
// */
//
//        String FILE_IN = PATH;
//        File f = new File(FILE_IN);
//        List<String> list = new ArrayList<String>();
//        list = getFileList(f);
//        //String text = null;
//
//
//        Template t = new Template(null, new StringReader(getTextFromTxt("F:\\respository\\yang\\src\\main\\resources\\templates\\sql.html")), null);
//       // File templateFile = org.springframework.util.ResourceUtils.getFile("classpath:templates\\sql.html");
//
//
//        //System.out.println(list.size());
//        List<Table> tableList =  new ArrayList<>();
//        for (String l : list) {
//            String text = getTextFromTxt(l);
//
//            List<HashMap> tables = JSON.parseArray(text, HashMap.class);
//            for (int i = 0; i < tables.size(); i++) {
//                String tableName = tables.get(i).get("name").toString();
//                String tableSchema = getTextFromTxt(PATH + "\\tables\\" + tableName + ".txt");
//                JsonRootBean jsonRootBean = JSON.parseObject(tableSchema, JsonRootBean.class);
//
//                tableList.add(jsonRootBean.getTable());
//
//
//
//                //System.out.println(tableSchema);
//            }
//
//        }
//
//
//        // 创建插值的map
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("tableList", tableList);
//        t.process(map, new OutputStreamWriter(System.out));
//
//        // 执行插值，并输出到指定的输出流中
//        //Writer writer = new FileWriter("D:\\aa.sql");
//        //t.process(map, writer);
//
//
//
//
//    }
//
////    @GetMapping("/testboot")
////    public List<Book> test() throws SQLException {
////        try {
////            dataSource.getConnection();
////            List<Book> bookList = bookDao.queryBook();
////            return bookList;
////        } catch (Exception e) {
////           throw e;
////        }
////    }
//
//
//    public static List<String> getFileList(File file) {
//
//        List<String> result = new ArrayList<String>();
//
//        if (!file.isDirectory()) {
//            //System.out.println(file.getAbsolutePath());
//            result.add(file.getAbsolutePath());
//        } else {
//            File[] directoryList = file.listFiles(new FileFilter() {
//                public boolean accept(File file) {
//                    if (file.isFile() && file.getName().indexOf("txt") > -1) {
//                        return true;
//                    } else {
//                        return false;
//                    }
//                }
//            });
//            for (int i = 0; i < directoryList.length; i++) {
//                result.add(directoryList[i].getPath());
//            }
//        }
//
//        return result;
//    }
//
//    public static String getTextFromTxt(String filePath) throws Exception {
//
//        FileReader fr = new FileReader(filePath);
//        BufferedReader br = new BufferedReader(fr);
//        StringBuffer buff = new StringBuffer();
//        String temp = null;
//        while ((temp = br.readLine()) != null) {
//            buff.append(temp + "\r\n");
//        }
//        br.close();
//        return buff.toString();
//    }
}
