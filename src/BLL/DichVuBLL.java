package BLL;
import java.util.*;
import DAL.DichVuDAL;
import DTO.DichVuDTO;
public class DichVuBLL {
	DichVuDAL DichVuDAL = new DichVuDAL();
		  /*
    ============================================================
                     Lấy danh sách dịch vụ         
    ============================================================
     */
	public ArrayList<DichVuDTO> LayDSDV(){
		return DichVuDAL.LayDSDichVu();
	}
}
