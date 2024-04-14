package bansach.demo.securiti;

public class endpond {

    public static String font_end_host = "http://localhost:3000";

    public static  final  String[] PUBLIC_GET_ENPOINS = {
            "/sach" ,
            "/sach/**",
            "/theloai" ,
            "/theloai/**",
           "/khachhang/search/**",
            "/taikhoan/kichhoat",


    };

    public static  final  String[] PUBLIC_POST_ENPOINS = {
            "/taikhoan/dangki",
            "taikhoan/dangnhap"
    };

    public static  final  String[] ADMIN_GET_ENPOINS = {
            "/taikhoan/kichhoat",
            "/taikhoan/kichhoat/**",
            "/khachhang",
            "khachhang/**" ,
            "/sach" ,
            "/sach/**",
            "/taikhoan/dangki",
            "/theloai" ,
            "/theloai/**"

    };


}
