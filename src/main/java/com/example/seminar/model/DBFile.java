package com.example.seminar.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.util.Arrays;

import javax.persistence.*;

@Entity
@Table(name = "files")
public class DBFile {
	 @Id
	    @GeneratedValue(generator = "uuid")
	    @GenericGenerator(name = "uuid", strategy = "uuid2")
	    private String id;

	    private String fileName;

	    private String fileType;

	    @Lob
	    private byte[] data;
	    
	    @ManyToOne
	    @JoinColumn(name="user_id", nullable=false)
	    private User user;

	    @Override
		public String toString() {
			return "DBFile [id=" + id + ", fileName=" + fileName + ", fileType=" + fileType + ", data="
					+ Arrays.toString(data) + ", user=" + user + "]";
		}

		public DBFile(String fileName, String fileType, byte[] data, User user) {
			this.fileName = fileName;
			this.fileType = fileType;
			this.data = data;
			this.user = user;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		
		}

		public DBFile() {

	    }
	    
		public DBFile(String fileName, String fileType, byte[] data) {
	        this.fileName = fileName;
	        this.fileType = fileType;
	        this.data = data;
	    }

	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getFileName() {
	        return fileName;
	    }

	    public void setFileName(String fileName) {
	        this.fileName = fileName;
	    }

	    public String getFileType() {
	        return fileType;
	    }

	    public void setFileType(String fileType) {
	        this.fileType = fileType;
	    }

	    public byte[] getData() {
	        return data;
	    }

	    public void setData(byte[] data) {
	        this.data = data;
	    }
}
