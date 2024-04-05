
import com.dao.DiaDiemDAO;
import com.dao.PhuongDAO;
import com.dao.QuanDAO;
import com.entites.DiaDiem;
import com.entites.Phuong;
import com.entites.Quan;
import com.google.gson.Gson;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ASUS
 */
public class MainApp {

    public static void main(String[] args) {
        DiaDiemDAO diaDiemDAO = new DiaDiemDAO();

        // Các điều kiện tìm kiếm (các tham số có thể có hoặc không)
        String tenDiaDiem = "Bà";
        int idDichVu = 2; // ID của dịch vụ
        int idGia = 2; // ID của giá
        int idPhuong = 53; // ID của phường
        int idQuan = 7; // ID của quận
        int idThanhPho = 1; // ID của thành phố
        
        // Gọi hàm search từ DiaDiemDAO
        List<DiaDiem> result = diaDiemDAO.SearchDiaDiem(tenDiaDiem, idDichVu, idGia, idPhuong, idQuan, idThanhPho);
        
         //In kết quả
        for (DiaDiem diaDiem : result) {
            System.out.println("Id: " + diaDiem.getId());
            System.out.println("Tên địa điểm: " + diaDiem.getTenDiaDiem());
            System.out.println("Tên dịch vụ: " + diaDiem.getDichVu().getTenDichVu());
            System.out.println("Mức giá: " + diaDiem.getGia().getMucGia());
            System.out.println("Tên phường: " + diaDiem.getPhuong().getTenPhuong());
            System.out.println("Tên quận: " + diaDiem.getQuan().getTenQuan());
            System.out.println("Tên thành phố: " + diaDiem.getThanhPho().getTenThanhPho());
            System.out.println("---------------------------------------");
        }
    }
}
