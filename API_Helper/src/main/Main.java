package main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    /**
     * 调用对方接口方法
     * @param path 对方或第三方提供的路径
     * @param data 向对方或第三方发送的数据，大多数情况下给对方发送JSON数据让对方解析
     */
    public static void interfaceUtil(String path,String data,String method) {
        try {
            URL url = new URL(path);
            //打开和url之间的连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            PrintWriter out = null;
            //请求方式
            conn.setRequestMethod(method);
//           //设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)"); 
            //conn.setRequestProperty("Content-Type", contentType);
            //设置是否向httpUrlConnection输出，设置是否从httpUrlConnection读入，此外发送post请求必须设置这两个
            //最常用的Http请求无非是get和post，get请求可以获取静态页面，也可以把参数放在URL字串后面，传递给servlet，
            //post与get的 不同之处在于post的参数不是放在URL字串里面，而是放在http请求的正文内。
            conn.setDoOutput(true);
            conn.setDoInput(true);
            //获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            //发送请求参数即数据
            out.print(data);
            //缓冲数据
            out.flush();
            //获取URLConnection对象对应的输入流
            InputStream is = conn.getInputStream();
            //构造一个字符流缓存
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String str = "";
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
            //关闭流
            is.close();
            //断开连接，最好写上，disconnect是在底层tcp socket链接空闲时才切断。如果正在被其他线程使用就不切断。
            //固定多线程的话，如果不disconnect，链接会增多，直到收发不出信息。写上disconnect后正常一些。
            conn.disconnect();
            
            System.out.println("完整结束");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
//    	interfaceUtil("http://api.map.baidu.com/place/v2/detail?uid=382e9d69d8f6f53bfbdc85c7&output=json&scope=2&ak=QnK5CEbH3MgaYdHm7GpzPYrXv65okhEk", "", "GET");
    	//圆形检索
    	interfaceUtil("http://api.map.baidu.com/place/v2/search?query=美食&location=39.915,116.404&scope=2&radius=2000&output=json&ak=QnK5CEbH3MgaYdHm7GpzPYrXv65okhEk", "", "GET");
    	//行政区域检索
//    	interfaceUtil("http://api.map.baidu.com/place/v2/search?query=餐饮&tag=餐饮&region=福州市&output=json&ak=QnK5CEbH3MgaYdHm7GpzPYrXv65okhEk&page_size=20&scope=2&filter=sort_name:overall_rating|sort_rule:0", "", "GET");
//    	interfaceUtil("https://restapi.amap.com/v3/geocode/regeo?output=json&location=116.310003,39.991957&key=648cc5bcca17ed24e349ac6a1d9e3ebd&radius=1000&extensions=all", "", "GET");
//    	interfaceUtil("https://restapi.amap.com/v3/geocode/geo?address=北京市朝阳区阜通东大街6号&output=XML&key=648cc5bcca17ed24e349ac6a1d9e3ebd", "", "GET");
//    	interfaceUtil("http://api.map.baidu.com/geocoding/v3/?address=山西省运城市盐湖区中银北大道一巷2号楼4单元102室&output=json&ak=QnK5CEbH3MgaYdHm7GpzPYrXv65okhEk", "","GET");

    }
}