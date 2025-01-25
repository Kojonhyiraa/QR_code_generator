package kttech.QrCodeGenerator.utils;

import kttech.QrCodeGenerator.models.User;
import lombok.var;

public class QRCodeGenerator {

    public static void generateQRCode(User user){

        //Path where we will save the generated QR code image
        String qrCodePath = "";
        //Name of the saved image
        String qrCodeName = qrCodePath+user.getFirstName()+user.getId()+"-QRCode.png";


        //Add dependency for QR code generator.Its called zxing
        var qr


    }

}
