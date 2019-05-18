/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sergey.bychkov.kogdaigra.model.old;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author 16715817
 */
@Entity
@Table(name = "ki_status")
@XmlRootElement

public class KiStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "status_id")
    private Integer statusId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "status_name")
    private String statusName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "status_style")
    private String statusStyle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "problem_status")
    private short problemStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "future_only_status")
    private short futureOnlyStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cancelled_status")
    private short cancelledStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "show_review_flag")
    private short showReviewFlag;
    @Basic(optional = false)
    @NotNull
    @Column(name = "show_date_flag")
    private short showDateFlag;
    @Basic(optional = false)
    @NotNull
    @Column(name = "good_status")
    private short goodStatus;

    public KiStatus() {
    }

    public KiStatus(Integer statusId) {
        this.statusId = statusId;
    }

    public KiStatus(Integer statusId, String statusName, String statusStyle, short problemStatus, short futureOnlyStatus, short cancelledStatus, short showReviewFlag, short showDateFlag, short goodStatus) {
        this.statusId = statusId;
        this.statusName = statusName;
        this.statusStyle = statusStyle;
        this.problemStatus = problemStatus;
        this.futureOnlyStatus = futureOnlyStatus;
        this.cancelledStatus = cancelledStatus;
        this.showReviewFlag = showReviewFlag;
        this.showDateFlag = showDateFlag;
        this.goodStatus = goodStatus;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusStyle() {
        return statusStyle;
    }

    public void setStatusStyle(String statusStyle) {
        this.statusStyle = statusStyle;
    }

    public short getProblemStatus() {
        return problemStatus;
    }

    public void setProblemStatus(short problemStatus) {
        this.problemStatus = problemStatus;
    }

    public short getFutureOnlyStatus() {
        return futureOnlyStatus;
    }

    public void setFutureOnlyStatus(short futureOnlyStatus) {
        this.futureOnlyStatus = futureOnlyStatus;
    }

    public short getCancelledStatus() {
        return cancelledStatus;
    }

    public void setCancelledStatus(short cancelledStatus) {
        this.cancelledStatus = cancelledStatus;
    }

    public short getShowReviewFlag() {
        return showReviewFlag;
    }

    public void setShowReviewFlag(short showReviewFlag) {
        this.showReviewFlag = showReviewFlag;
    }

    public short getShowDateFlag() {
        return showDateFlag;
    }

    public void setShowDateFlag(short showDateFlag) {
        this.showDateFlag = showDateFlag;
    }

    public short getGoodStatus() {
        return goodStatus;
    }

    public void setGoodStatus(short goodStatus) {
        this.goodStatus = goodStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statusId != null ? statusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KiStatus)) {
            return false;
        }
        KiStatus other = (KiStatus) object;
        if ((this.statusId == null && other.statusId != null) || (this.statusId != null && !this.statusId.equals(other.statusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sergey.bychkov.kogdaigra.model.old.KiStatus[ statusId=" + statusId + " ]";
    }
    
}
