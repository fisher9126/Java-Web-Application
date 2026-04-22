package re.demohackathon.dto;

import jakarta.validation.constraints.Min;
import org.springframework.web.multipart.MultipartFile;
import re.demohackathon.validator.CheckNumber;


@CheckNumber
public class ImgFile {

    @Min(value=1,message = "Min là 1")
    private int a;
    @Min(value=1,message = "Min là 1")
    private int b;
    private MultipartFile imgFile;

    public ImgFile() {
    }


    public ImgFile(int a, int b, MultipartFile imgFile) {
        this.a = a;
        this.b = b;
        this.imgFile = imgFile;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public MultipartFile getImgFile() {
        return imgFile;
    }

    public void setImgFile(MultipartFile imgFile) {
        this.imgFile = imgFile;
    }
}
