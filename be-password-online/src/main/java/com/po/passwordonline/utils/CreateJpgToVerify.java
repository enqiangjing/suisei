package com.po.passwordonline.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import com.po.passwordonline.mapper.VerifyCodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.po.passwordonline.model.VerifyCode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component // a.非Controller使用@Autowired注解
public class CreateJpgToVerify {

    private VerifyCodeMapper verifyCodeMapper;

    @Autowired // b.非Controller使用@Autowired注解
    public void setInjectedBean(VerifyCodeMapper verifyCodeMapper) {
        this.verifyCodeMapper = verifyCodeMapper;
    }

    // c.非Controller使用@Autowired注解
    public static CreateJpgToVerify createJpgToVerify;

    /**
     * @apiNote 非Controller使用Mapper a-d点
     */
    @PostConstruct // d.非Controller使用@Autowired注解
    public void init() {
        createJpgToVerify = this;
    }

    /**
     * @param request 请求信息
     * @return 返回图片
     * @apiNote 创建图片验证码
     */
    public BufferedImage createImg(HttpServletRequest request, String time) {

        // 1.数据准备
        VerifyCode vc = new VerifyCode();
        vc.setFindIp(request.getRemoteAddr()); // 插入访问IP
        vc.setAddTime(time); // 插入时间

        int width = 200, height = 60;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics gh = image.getGraphics(); // BasicStroke stroke = new BasicStroke(3);

        // 2.随机数
        Random r = new Random();

        // 填充颜色
        gh.setColor(new Color(r.nextInt(100), r.nextInt(100), r.nextInt(100)));
        gh.fillRect(0, 0, 200, 60);

        String code1 = String.valueOf(r.nextInt(9));
        String code2 = String.valueOf(r.nextInt(9));
        String code3 = String.valueOf(r.nextInt(9));
        String code4 = String.valueOf(r.nextInt(9));

        // 3.验证码插入
        try {
            vc.setCodeValue(code1 + code2 + code3 + code4);
            createJpgToVerify.verifyCodeMapper.insertCode(vc);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("验证码入库失败");
            gh.drawString("错误！", 30, 40);
            return image;
        }

        Graphics2D g2 = (Graphics2D) gh;

        Font font = new Font("Consolas", Font.BOLD, r.nextInt(15) + 45); // 字体
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate(Math.toRadians(r.nextInt(60)), 0, 0);
        Font rotatedFont = font.deriveFont(affineTransform);
        g2.setColor(new Color(r.nextInt(155) + 100, r.nextInt(155) + 100, r.nextInt(155) + 100));
        g2.setFont(rotatedFont);
        g2.drawString(code1, r.nextInt(10), r.nextInt(14) + 34);

        font = new Font("Consolas", Font.BOLD, r.nextInt(15) + 45); // 字体
        affineTransform = new AffineTransform();
        affineTransform.rotate(Math.toRadians(r.nextInt(60)), 0, 0);
        rotatedFont = font.deriveFont(affineTransform);
        g2.setColor(new Color(r.nextInt(155) + 100, r.nextInt(155) + 100, r.nextInt(155) + 100));
        g2.setFont(rotatedFont);
        g2.drawString(code2, r.nextInt(10) + 50, r.nextInt(14) + 34);

        font = new Font("Consolas", Font.BOLD, r.nextInt(15) + 45); // 字体
        affineTransform = new AffineTransform();
        affineTransform.rotate(Math.toRadians(r.nextInt(60)), 0, 0);
        rotatedFont = font.deriveFont(affineTransform);
        g2.setColor(new Color(r.nextInt(155) + 100, r.nextInt(155) + 100, r.nextInt(155) + 100));
        g2.setFont(rotatedFont);
        g2.drawString(code3, r.nextInt(10) + 100, r.nextInt(14) + 34);

        font = new Font("Consolas", Font.BOLD, r.nextInt(15) + 45); // 字体
        affineTransform = new AffineTransform();
        affineTransform.rotate(Math.toRadians(r.nextInt(60)), 0, 0);
        rotatedFont = font.deriveFont(affineTransform);
        g2.setColor(new Color(r.nextInt(155) + 100, r.nextInt(155) + 100, r.nextInt(155) + 100));
        g2.setFont(rotatedFont);
        g2.drawString(code4, r.nextInt(10) + 150, r.nextInt(14) + 34);

        for (int i = 0; i < 21; i++) {
            g2.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            g2.drawLine(r.nextInt(200), r.nextInt(60), r.nextInt(200), r.nextInt(60));
        }
        g2.dispose();

        return image;
    }
}
