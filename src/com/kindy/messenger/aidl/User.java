package com.kindy.messenger.aidl;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
	
	public int id;
	public String name;
	public int age;

	public User() {

	}
	
	private User(Parcel source) {
		id = source.readInt();
		name = source.readString();
		age = source.readInt();
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	@Override
	public int describeContents() {
		return 0;
	}

	/**
	 * 将对象序列号 dest 就是对象即将写入的目的对象 flags 有关对象序列号的方式的标识
	 * 这里要注意，写入的顺序要和在createFromParcel方法中读出的顺序完全相同。例如这里先写入的为name，
	 * 那么在createFromParcel就要先读name
	 */
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(id);
		dest.writeString(name);
		dest.writeInt(age);
	}
	
	public void readFromParcel(Parcel _reply) {
		id = _reply.readInt();
		name = _reply.readString();
		age = _reply.readInt();
	}

	/**
	 * 在想要进行序列号传递的实体类内部一定要声明该常量。常量名只能是CREATOR,类型也必须是 Parcelable.Creator<T>
	 */
	public static final Parcelable.Creator<User> CREATOR = new Creator<User>() {

		/**
		 * 创建一个要序列号的实体类的数组，数组中存储的都设置为null
		 */
		@Override
		public User[] newArray(int size) {
			return new User[size];
		}

		/***
		 * 根据序列号的Parcel对象，反序列号为原本的实体对象 读出顺序要和writeToParcel的写入顺序相同
		 */
		@Override
		public User createFromParcel(Parcel source) {
			return new User(source);
		}
	};

}
