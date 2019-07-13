//
// Created by nico on 2019/7/8.
//

#include <iostream>
#include <boost/scoped_ptr.hpp>

// Function2
#include <boost/asio/io_context.hpp>
#include <boost/asio/deadline_timer.hpp>

using namespace std;

class CMyClass
{
public:
    explicit CMyClass()
    {
        cout << "CMyClass Construction function !" << endl;
    }

    ~CMyClass()
    {
        cout << "CMyClass Destruct function" << endl;
    }

    void MyFunc(void){

        cout << "Do Something...." << endl;
    }
};

void Function1(void)
{
    //boost::scoped_ptr是一个简单的智能指针，它
    //能保证离开作用域后对象被自动释放，能避免由于
    //忘记释放而导致的内存泄漏。
    //验证运行的正确性是：打印：Now, Quit Function ...
    //之后，打印：CMyClass Destruct function
    boost::scoped_ptr<CMyClass> spMyClass(new CMyClass());
    spMyClass->MyFunc();
    cout << "Now, Quit Function ..." << endl;
}

// boost test2
void Print(boost::system::error_code ec){
    std::cout << "Hello World!" << std::endl;
}
void Function2(void)
{
    boost::asio::io_context ioc;
    boost::asio::deadline_timer t(ioc, boost::posix_time::seconds(3));
    t.async_wait(&Print);
    ioc.run();
}