package com.spring.boot.rocks;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
//import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;

import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "app_user")
public class AppUser implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotEmpty(message = "{not.empty.username}")
	@Size(min = 4, max = 50, message = "{minmax.size.username}")
	@Column(name = "username")
	private String username;

	@NotEmpty(message = "{not.empty.password}")
	@Size(min = 6, max = 100, message = "{minmax.size.password}")
	@Column(name = "password")
	private String password;

	@Transient
	private String passwordConfirm;

	@NotEmpty(message = "{not.empty.useremail}")
	@Email(message = "{not.valid.useremail}")
//	@Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", message = "{still.not.valid.useremail}")
//	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "{not.valid.useremail}")
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "mydomain.com$", message = "{not.valid.useremail}")
	@Column(name = "useremail")
	private String useremail;

	@NotEmpty(message = "{not.empty.userfirstname}")
	@Column(name = "userfirstname")
	private String userfirstname;

	@NotEmpty(message = "{not.empty.userlastname}")
	@Column(name = "userlastname")
	private String userlastname;

	@NotEmpty(message = "{not.empty.useraddress}")
	@Column(name = "useraddress")
	private String useraddress;

	@Column(name = "userenabled")
	private boolean userenabled;

	@Column(name = "userconfirmationtoken")
	private String userconfirmationtoken;

	@Column(name = "userdatecreated")
	private Date userdatecreated;

	@Column(name = "usercreatedby")
	private String usercreatedby;

	@Column(name = "userdatemodified")
	private Date userdatemodified;

	@Column(name = "usermodifiedby")
	private String usermodifiedby;

	public AppUser() {
	}

	public AppUser(Long id) {
		this.id = id;
	}

	public AppUser(Long id, String username, String password, String passwordConfirm, String useremail,
			String userfirstname, String userlastname, String useraddress, boolean userenabled, Date userdatecreated,
			String usercreatedby, Date userdatemodified, String usermodifiedby) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.useremail = useremail;
		this.userfirstname = userfirstname;
		this.userlastname = userlastname;
		this.useraddress = useraddress;
		this.userenabled = userenabled;
		this.userdatecreated = userdatecreated;
		this.usercreatedby = usercreatedby;
		this.userdatemodified = userdatemodified;
		this.usermodifiedby = usermodifiedby;
	}


	public Long getId() {
		return id;
	}

	@XmlElement
	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	@XmlElement
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUserfirstname() {
		return userfirstname;
	}

	public void setUserfirstname(String userfirstname) {
		this.userfirstname = userfirstname;
	}

	public String getUserlastname() {
		return userlastname;
	}

	public void setUserlastname(String userlastname) {
		this.userlastname = userlastname;
	}

	public String getUseraddress() {
		return useraddress;
	}

	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}

	public boolean isUserenabled() {
		return userenabled;
	}

	public void setUserenabled(boolean userenabled) {
		this.userenabled = userenabled;
	}
	

	public String getUserconfirmationtoken() {
		return userconfirmationtoken;
	}

	public void setUserconfirmationtoken(String userconfirmationtoken) {
		this.userconfirmationtoken = userconfirmationtoken;
	}

	public Date getUserdatecreated() {
		return userdatecreated;
	}

	public void setUserdatecreated(Date userdatecreated) {
		this.userdatecreated = userdatecreated;
	}

	public String getUsercreatedby() {
		return usercreatedby;
	}

	public void setUsercreatedby(String usercreatedby) {
		this.usercreatedby = usercreatedby;
	}

	public Date getUserdatemodified() {
		return userdatemodified;
	}

	public void setUserdatemodified(Date userdatemodified) {
		this.userdatemodified = userdatemodified;
	}

	public String getUsermodifiedby() {
		return usermodifiedby;
	}

	public void setUsermodifiedby(String usermodifiedby) {
		this.usermodifiedby = usermodifiedby;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof AppUser)) {
			return false;
		}
		AppUser other = (AppUser) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.spring.boot.rocks.model.AppUser[ id=" + id + " ]";
	}

}
