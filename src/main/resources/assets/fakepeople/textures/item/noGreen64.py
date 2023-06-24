from PIL import Image
import colorsys
import os

# 遍历目录下所有png文件
for filename in os.listdir('.'):
    if filename.endswith('.png'):
        # 打开图片
        image = Image.open(filename)
        
        # 无插值缩放为64x64
        image = image.resize((64, 64), resample=Image.NEAREST)
        
        image = image.convert('RGBA')
        # 将所有纯绿色的部分替换为透明
        pixdata = image.load()
        width, height = image.size
        for y in range(height):
            for x in range(width):
                r, g, b, a = pixdata[x, y]
                h, s, v = colorsys.rgb_to_hsv(r, g, b)
                # 判断绿色区域并替换为透明
                if 90 <= h and h <= 150 and 0.3 <= s and s <= 1.0 and 0.3 <= v and v <= 1.0:
                    pixdata[x, y] = (0, 0, 0, 0)
        
        # 保存图片
        image.save(filename)
        print(filename)
