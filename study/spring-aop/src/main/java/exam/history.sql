create table t77_history(
    class_name varchar2(100),
    method_name varchar2(100),
    call_time date default sysdate
);


select * from t77_history;