package re.demohkt.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class UploadService {
    private Cloudinary cloudinary;

    public UploadService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }
    public String upload(MultipartFile file) throws IOException{
        try{
            Map uploadResult=cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            String secureUrl=(String) uploadResult.get("secure_url");
            if(secureUrl==null || secureUrl.isEmpty()){
                throw new IOException("Secure URL not found in Cloudinary upload response");
            }
            return secureUrl;
        } catch (IOException e) {
            throw new IOException(e);
        }
    }
}
