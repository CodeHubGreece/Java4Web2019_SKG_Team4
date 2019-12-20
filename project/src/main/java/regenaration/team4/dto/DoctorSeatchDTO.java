package regenaration.team4.dto;

import java.util.Date;

public class DoctorSeatchDTO {
    private Date fromDate;
    private Date toDate;
    public DoctorSeatchDTO(){}
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
}
