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

        public ProjectBuilder setProjectId(String projectId) {
            this.projectId = projectId;
            return this;
        }

        public ProjectBuilder setProjectName(String projectName) {
            this.projectName = projectName;
            return this;
        }

        public ProjectBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public ProjectBuilder setStatus(ProjectStatus status) {
            this.status = status;
            return this;
        }

        public ProjectBuilder setBuyerId(String buyerId) {
            this.buyerId = buyerId;
            return this;
        }

        public ProjectBuilder setSellerId(String sellerId) {
            this.sellerId = sellerId;
            return this;
        }

        public ProjectBuilder setLowestBidPrice(Double lowestBidPrice) {
            this.lowestBidPrice = lowestBidPrice;
            return this;
        }

        public ProjectBuilder setPostedDate(Date postedDate) {
            this.postedDate = postedDate;
            return this;
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
