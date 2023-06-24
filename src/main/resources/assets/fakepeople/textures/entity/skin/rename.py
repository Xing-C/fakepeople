import os

# 获取当前目录
current_directory = os.getcwd()

# 获取当前目录下的所有文件
files = os.listdir(current_directory)

# 过滤出PNG文件
png_files = [file for file in files if file.endswith(".png")]

# 重命名PNG文件
for i, file in enumerate(png_files):
    new_name = "a{}.png".format(i)
    os.rename(file, new_name)
    print("将文件 {} 重命名为 {}".format(file, new_name))
