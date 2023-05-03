//package com.webite.crossplatform.components;
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.util.List;
//
//public class ImageConverter {
//    public static List<GoodsTable> decodeBlobToJpg(List<GoodsTable> goodsList) {
//        for (GoodsTable goods : goodsList) {
//            byte[] blobData = goods.getImg();
//            if (blobData != null) {
//                try {
//                    BufferedImage image = ImageIO.read(new ByteArrayInputStream(blobData));
//                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                    ImageIO.write(image, "jpg", baos);
//                    goods.setImg(baos.toByteArray());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return goodsList;
//    }
//
//}
