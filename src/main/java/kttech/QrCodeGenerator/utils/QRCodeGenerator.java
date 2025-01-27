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
    public static void generateQRCode(User user) throws WriterException, IOException {
        String qrCodePath = "src/main/resources/static";
        String qrCodeName = qrCodePath + user.getFirstName() + user.getId() + "-QRCode.png";

        var qrCodeWriter = new QRCodeWriter();

        // Simplify the QR code content
        String qrContent = String.format(
                "{\"id\":%d,\"firstName\":\"%s\",\"lastName\":\"%s\",\"email\":\"%s\",\"mobileNumber\":\"%s\"}",
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getMobileNumber()
        );

        System.out.println("QR Code Content: " + qrContent); // Debugging

        BitMatrix bitMatrix = qrCodeWriter.encode(
                qrContent,
                BarcodeFormat.QR_CODE,
                600, // Increased size
                600
        );

        Path path = FileSystems.getDefault().getPath(qrCodeName);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
}