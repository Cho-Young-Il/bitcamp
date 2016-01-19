package kr.co.mlec.common;

import java.io.File;
import java.util.UUID;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MLecFileRenamePolicy 
					implements FileRenamePolicy {

	@Override
	public File rename(File f) {
		// test.jpg : 원래 파일명
		// f.getName();
		// UUID 를 통해서 고유 아이디 얻기
		// id : 1232192
		// 실제 저장될 파일명 
		// id + ".jpg" -> 1232192.jpg
		String name = f.getName();
		// 확장자 구하기
		String ext = "";
		int dot = name.lastIndexOf(".");
		// . 이 존재할 경우
		if (dot != -1) {
			ext = name.substring(dot);
		}
		return new File(
			f.getParent(), 
			UUID.randomUUID().toString() + ext);
	}
}










