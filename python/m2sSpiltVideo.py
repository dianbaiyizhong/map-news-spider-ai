import argparse
import os

import cv2
from moviepy import VideoFileClip


def extract_second_half(input_video, output_video):
    """
    截取视频的后半部分并保存

    参数:
        input_video (str): 输入视频文件路径
        output_video (str): 输出视频文件路径
    """
    # 加载视频
    video = VideoFileClip(input_video)

    # 计算视频总时长
    total_duration = video.duration

    # 计算后半部分的开始时间（中点）
    start_time = total_duration / 3 * 2

    # 截取后半部分
    second_half = video.subclipped(start_time, total_duration)

    # 保存结果
    second_half.write_videofile(output_video)

    # 关闭视频对象
    video.close()
    second_half.close()


def main():
    parser = argparse.ArgumentParser(description="示例脚本：接收参数")
    # 添加参数
    parser.add_argument("--input", "-i", type=str, required=True, help="输入文件路径")

    parser.add_argument("--verbose", "-v", action="store_true", help="启用详细模式")

    args = parser.parse_args()  # 解析参数
    print(f"输入文件: {args.input}")
    dir_name = os.path.dirname(args.input)
    base_name = os.path.basename(args.input)
    file_name, file_ext = os.path.splitext(base_name)
    spilt_path = dir_name + "/" + file_name + "_spilt" + file_ext
    extract_second_half(args.input, spilt_path)
    # os.remove(args.input)
    # os.rename(spilt_path, args.input)
    print("success!")


if __name__ == "__main__":
    main()
