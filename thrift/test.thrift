namespace java com.wdd.thrift.service

service TestThrift{
    string getStr(1:string str1, 2:string str2),
    string getInt(1:i32 val)
}