package kttech.QrCodeGenerator.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.EncodeHintType;
import kttech.QrCodeGenerator.models.User;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class QRCodeGenerator {
    public static void generateQRCode(User user) throws WriterException, IOException {
        String qrCodePath = "src/main/resources/static";
        String qrCodeName = qrCodePath + user.getFirstName() + user.getId() + "-QRCode.png";

        var qrCodeWriter = new QRCodeWriter();

        // Format user data in column format with URL-encoded newlines
        String qrContent = String.format(
                "{  id: \"%d\"   ,    firstName: \" %s \"   ,    lastName: \"%s\"   ,    email : \"%s\"   ,    mobileNumber:\"%s\"  }",
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getMobileNumber()
        );

        System.out.println("QR Code Content: " + qrContent); // Debugging

        // Set error correction level to HIGH
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, "H"); // H = High error correction

        BitMatrix bitMatrix = qrCodeWriter.encode(
                qrContent,
                BarcodeFormat.QR_CODE,
                600,
                600,
                hints
        );

        Path path = FileSystems.getDefault().getPath(qrCodeName);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
}