import java.util.Date;
public class MiniBoardVO {
    private Integer no;
    private String writer;
    private String title;
    private String content;
    private Date regDate;
    private Integer viewCnt;


    public void setNo(Integer no) { 
        this.no = no;
    }

    public Integer getNo() { 
        return no;
    }
    public void setWriter(String writer) { 
        this.writer = writer;
    }

    public String getWriter() { 
        return writer;
    }

    public void setTitle(String title) { 
        this.title = title;
    }

    public String getTitle() { 
        return title;
    }

    public void setContent(String content) { 
        this.content = content;
    }

    public String getContent() { 
        return content;
    }

    public void setRegDate(Date regDate) { 
        this.regDate = regDate;
    }

    public Date getRegDate() { 
        return regDate;
    }

    public void setViewCnt(Integer viewCnt) { 
        this.viewCnt = viewCnt;
    }

    public Integer getViewCnt() { 
        return viewCnt;
    }
}