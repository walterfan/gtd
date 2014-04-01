package com.github.walterfan.gtd.parcel;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
	private String userName;
	private String password;
	
	public static final Parcelable.Creator<User>  CREATOR = new Creator<User> () {
		@Override
		public User createFromParcel(Parcel source) {
			User user = new User();
			user.userName = source.readString();
			user.password = source.readString();
			return user;
		}
		
		@Override
		public User[] newArray(int size) {
			return new User[size];
		}
	};

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(userName);
		dest.writeString(password);

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
