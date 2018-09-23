package cn.ylcto.test;

public class TestMD5Code {
    public static void main(String[] args) {
        String email = "ylcto@163.com";
        String password = "ylcto";
        System.out.println(new cn.ylcto.util.MD5Code().getMD5ofStr(password+email));
    }
}
