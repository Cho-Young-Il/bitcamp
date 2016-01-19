package kr.co.mlec.myprj.board;

import java.util.Date;

public class MiniBoardCommentVO {
    private int commentNo;
    private int no;
    private String nickName;
    private String content;
    private String regDate;


    public void setCommentNo(int commentNo) { 
        this.commentNo = commentNo;
    }

    public int getCommentNo() { 
        return commentNo;
    }

    public void setNo(int no) { 
        this.no = no;
    }

    public int getNo() { 
        return no;
    }

    public void setNickName(String nickName) { 
        this.nickName = nickName;
    }

    public String getNickName() { 
        return nickName;
    }

    public void setContent(String content) { 
        this.content = content;
    }

    public String getContent() { 
        return content;
    }

    public void setRegDate(String regDate) { 
        this.regDate = regDate;
    }

    public String getRegDate() { 
        return regDate;
    }
}