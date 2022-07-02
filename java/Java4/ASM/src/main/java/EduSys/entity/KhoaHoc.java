/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EduSys.entity;

import EduSys.utils.XDate;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author
 */
public class KhoaHoc {
    private int maKH;
    private String maCD;
    private float hocPhi;
    private int thoiLuong;
    private Date ngayKG;
    private String ghiChu;
    private String maNV;
    private Date ngayTao;
    private boolean IdList=true;

    public boolean isIdList() {
        return IdList;
    }
    
    public KhoaHoc() {
	
	}

	public KhoaHoc(int maKH, String maCD, float hocPhi, int thoiLuong, Date ngayKG, String ghiChu, String maNV,
			Date ngayTao, boolean idList) {
		super();
		this.maKH = maKH;
		this.maCD = maCD;
		this.hocPhi = hocPhi;
		this.thoiLuong = thoiLuong;
		this.ngayKG = ngayKG;
		this.ghiChu = ghiChu;
		this.maNV = maNV;
		this.ngayTao = ngayTao;
		IdList = idList;
	}

	public void setIdList(boolean IdList) {
        this.IdList = IdList;
    }
    
    
    @Override
    public String toString(){
        return this.maCD+" ("+this.ngayKG+")";
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
    	if(maKH > Integer.MAX_VALUE){
            throw new IllegalArgumentException("Ma khoa hoc da dat toi gioi han");
        }
        if (maKH < 0) {
            throw new IllegalArgumentException("Ma khoc không đuọc nhỏ hơn 0");
        }
        if (maKH == 0) {
            throw new IllegalArgumentException("Ma khoc không đuọc bằng 0");
        }
            
        
        this.maKH = maKH;
    }

    public String getMaCD() {
        return maCD;
    }

    public void setMaCD(String maCD) {
        if(maCD.isBlank()){
            throw new IllegalArgumentException("Mã chuyên đề không được để trống");
        }
        if(!(checkMaCD(maCD))){
            throw new IllegalArgumentException("Mã chuyên đề không đúng định dạng");
        }
        this.maCD = maCD;
    }

    public float getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(float hocPhi) {
        if(hocPhi < 0){
            throw new IllegalArgumentException("Học phí không được nhỏ hơn 0");
        }
        if(hocPhi > Float.MAX_VALUE){
            throw new IllegalArgumentException("Học phí đã đạt tới giới hạn");
        }
        this.hocPhi = hocPhi;
    }


    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        
        if(thoiLuong < 0){
            throw new IllegalArgumentException("Thời lượng không được nhỏ hơn 0");
        }
        if(thoiLuong > Integer.MAX_VALUE){
            throw new IllegalArgumentException("Thời lượng đã đạt tới giới hạn");
        }
        this.thoiLuong = thoiLuong;
    }

    public Date getNgayKG() {
        return ngayKG;
    }

    public void setNgayKG(Date ngayKG) {
        if(ngayKG == null){
            throw new IllegalArgumentException("Ngày không được để trống");
        }
        //check ngayKG < date now
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNow = sf.format(new Date());
        String dateKG = sf.format(ngayKG);
        if(dateKG.compareTo(dateNow) < 0){
            throw new IllegalArgumentException("Ngày không được nhỏ hơn ngày hiện tại");
        }
            
        this.ngayKG = ngayKG;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        if(maNV.isBlank()){
            throw new IllegalArgumentException("Mã nhân viên không được để trống");
        }
        if(!(checkMaCD(maNV))){
            throw new IllegalArgumentException("Mã nhân viên không đúng định dạng");
        }
        this.maCD = maCD;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        if(ngayTao == null){
            throw new IllegalArgumentException("Ngày không được để trống");
        }
        //check ngayTao < date now with simple date format
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNow = sf.format(new Date());
        String dateNgayTao = sf.format(ngayTao);
        if(dateNgayTao.compareTo(dateNow) < 0){
            throw new IllegalArgumentException("Ngày không được nhỏ hơn ngày hiện tại");
        }
        this.ngayTao = ngayTao;
        
    }
    public static boolean checkMaCD(String str) {
		String regex = "[a-zA-Z0-9]{3,15}";
		boolean kt = str.matches(regex);
		return kt;
	}
	public static boolean checkTen(String str) {
		String regex = "[a-zA-Z]{3,100}";
		boolean kt = str.matches(regex);
		return kt;
	}
}
