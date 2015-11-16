package com.kindy.messenger.aidl;

import com.kindy.messenger.aidl.User;

interface IAIDL {

	User getUser(String name);
	
    /**
	 * <br> in 输入参数：相当于形参，不会改变实参值
	 * <br> out 输出参数：引用，但已被重新初始化，
	 * <br> inout 输入输出参数：引用，且保持原值
	 */
	void trainUser(inout User user);
}