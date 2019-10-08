package com.intuit.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Project {

    private String projectId;
    private String projectName;
    private String type;
    private ProjectStatus status;
    private String buyerId;
    private String sellerId;
    private Double lowestBidPrice;
    private Date postedDate;

    public Project(String projectId, String projectName, String type, ProjectStatus status,String buyerId, String sellerId, Double lowesetBidPrice, Date postedDate){
        this.projectId = projectId;
        this.projectName = projectName;
        this.type = type;
        this.status = status;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.lowestBidPrice = lowesetBidPrice;
        this.postedDate = postedDate;
    }

    private static class ProjectBuilder {

        private String projectId;
        private String projectName;

        public void setProjectId(String projectId) {
            this.projectId = projectId;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setStatus(ProjectStatus status) {
            this.status = status;
        }

        public void setBuyerId(String buyerId) {
            this.buyerId = buyerId;
        }

        public void setSellerId(String sellerId) {
            this.sellerId = sellerId;
        }

        public void setLowestBidPrice(Double lowestBidPrice) {
            this.lowestBidPrice = lowestBidPrice;
        }

        public void setPostedDate(Date postedDate) {
            this.postedDate = postedDate;
        }

        private String type;
        private ProjectStatus status;
        private String buyerId;
        private String sellerId;
        private Double lowestBidPrice;
        private Date postedDate;

        public Project build(){
            return new Project(projectId, projectName, type, status,buyerId,sellerId,lowestBidPrice,postedDate);
        }

    }
}
