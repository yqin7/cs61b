package capers;

import java.io.File;
import java.io.IOException;
public class FileDemo {

    public static void main(String[] args) {
        // 创建一个代表目录的File对象
        File d = new File("dummy");

        // 检查dummy目录是否已经存在
        if (!d.exists()) {
            // 创建这个目录
            d.mkdir();
        }

        // 创建一个File对象
        File f = new File(d, "dummy.txt"); // 注意这里，我们在dummy目录下创建了dummy.txt文件

        // 检查dummy.txt是否已经存在
        if (!f.exists()) {
            try {
                // 创建这个文件
                f.createNewFile();
            } catch (IOException e) {
                System.out.println("Error creating the file: " + e.getMessage());
            }
        }

        // 使用Utils类将字符串"Hello World"写入dummy.txt
        Utils.writeContents(f, "Hello World2");
    }
}