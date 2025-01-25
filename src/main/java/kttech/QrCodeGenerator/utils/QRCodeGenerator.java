package kttech.QrCodeGenerator.utils;

import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import kttech.QrCodeGenerator.models.User;


public class QRCodeGenerator {

    public static void generateQRCode(User user){

        //Path where we will save the generated QR code image
        String qrCodePath = "";
        //Name of the saved image
        String qrCodeName = qrCodePath+user.getFirstName()+user.getId()+"-QRCode.png";


        //Add dependency for QR code generator.Its called zxing
        var qrCodeQwriter = new QRCodeWriter();

        BitMatrix bitMatrix ;



    }

}
