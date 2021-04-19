namespace java com.wdd.thrift.service

service UserService{
    string getUser(1:string name),
    string getAge(1:i32 age)
}