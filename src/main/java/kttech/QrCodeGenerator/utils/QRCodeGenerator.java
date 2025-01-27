package kttech.QrCodeGenerator.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import kttech.QrCodeGenerator.models.User;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;


public class QRCodeGenerator {
    //Utility class to generate QR codes.
    public static void generateQRCode(User user) throws WriterException, IOException {

        //Path where we will save the generated QR code image
        String qrCodePath = "src/main/resources/static";
        //Name of the saved image
        String qrCodeName = qrCodePath+user.getFirstName()+user.getId()+"-QRCode.png";


        //Add dependency for QR code generator.Its called zxing
        var qrCodeWriter = new QRCodeWriter();


        BitMatrix bitMatrix = qrCodeWriter.encode(
                "ID:"+user.getId() +"\n"+
                        "First Name:"+user.getFirstName() +"\n"+
                        "Last Name:"+user.getLastName() +"\n"+
                        "Email:"+user.getEmail() +"\n"+
                        "Mobile Number:"+user.getMobileNumber() +"\n",
                BarcodeFormat.QR_CODE,
                400,
                400 ) ;

        Path path = FileSystems.getDefault().getPath(qrCodeName);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG",path);

    }
}
