package com.hnfnu.zyw.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="v_subject_group")
public class SubjectGroupVo {
		//id
		private Integer id;
		//科目名称
		private String name;
		private String imageUrl;
		private int isDisplay;
		private int groupId;
		private String groupName;
		private String remark;
		
		
		public SubjectGroupVo() {
			super();
		}

		@Id
		@GeneratedValue
		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public int getGroupId() {
			return groupId;
		}


		public void setGroupId(int groupId) {
			this.groupId = groupId;
		}


		public String getGroupName() {
			return groupName;
		}


		public void setGroupName(String groupName) {
			this.groupName = groupName;
		}


		public String getRemark() {
			return remark;
		}


		public void setRemark(String remark) {
			this.remark = remark;
		}
		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		public int getIsDisplay() {
			return isDisplay;
		}

		public void setIsDisplay(int isDisplay) {
			this.isDisplay = isDisplay;
		}
		
}
