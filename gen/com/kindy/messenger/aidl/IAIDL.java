/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: D:\\Android\\Workspace\\GitHub\\Messenger\\src\\com\\kindy\\messenger\\aidl\\IAIDL.aidl
 */
package com.kindy.messenger.aidl;
public interface IAIDL extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.kindy.messenger.aidl.IAIDL
{
private static final java.lang.String DESCRIPTOR = "com.kindy.messenger.aidl.IAIDL";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.kindy.messenger.aidl.IAIDL interface,
 * generating a proxy if needed.
 */
public static com.kindy.messenger.aidl.IAIDL asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.kindy.messenger.aidl.IAIDL))) {
return ((com.kindy.messenger.aidl.IAIDL)iin);
}
return new com.kindy.messenger.aidl.IAIDL.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getUser:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
User _result = this.getUser(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_trainUser:
{
data.enforceInterface(DESCRIPTOR);
User _arg0;
if ((0!=data.readInt())) {
_arg0 = User.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.trainUser(_arg0);
reply.writeNoException();
if ((_arg0!=null)) {
reply.writeInt(1);
_arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.kindy.messenger.aidl.IAIDL
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public User getUser(java.lang.String name) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
User _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
mRemote.transact(Stub.TRANSACTION_getUser, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = User.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
	 * <br> in 输入参数：相当于形参，不会改变实参值
	 * <br> out 输出参数：引用，但已被重新初始化，
	 * <br> inout 输入输出参数：引用，且保持原值
	 */
@Override public void trainUser(User user) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((user!=null)) {
_data.writeInt(1);
user.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_trainUser, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
user.readFromParcel(_reply);
}
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_getUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_trainUser = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
public User getUser(java.lang.String name) throws android.os.RemoteException;
/**
	 * <br> in 输入参数：相当于形参，不会改变实参值
	 * <br> out 输出参数：引用，但已被重新初始化，
	 * <br> inout 输入输出参数：引用，且保持原值
	 */
public void trainUser(User user) throws android.os.RemoteException;
}
