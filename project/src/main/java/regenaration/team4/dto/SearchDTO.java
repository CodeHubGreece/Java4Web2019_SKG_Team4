package regenaration.team4.dto;
import java.util.Date;
public class SearchDTO {
    private Date fromDate;
    private Date toDate;
    private Integer specialtyId;
    public SearchDTO(){}
    public Date getFromDate() {
        return fromDate;
    }
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }
    public Date getToDate() {
        return toDate;
    }
    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
    public Integer getSpecialtyId() {
        return specialtyId;
    }
    public void setSpecialtyId(Integer specialtyId) {
        this.specialtyId = specialtyId;
    }
}