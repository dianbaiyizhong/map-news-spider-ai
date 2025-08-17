import argparse
import os

import cv2
from PIL import Image
from moviepy import VideoFileClip


def cut_video(input_path, output_path):
    # 裁剪区域 (x, y, width, height)
    x, y = 362, 189  # 起始坐标
    w, h = 1300, 675  # 裁剪宽度和高度

    # 打开视频
    cap = cv2.VideoCapture(input_path)

    # 获取原视频的帧率和尺寸
    fps = int(cap.get(cv2.CAP_PROP_FPS))
    original_width = int(cap.get(cv2.CAP_PROP_FRAME_WIDTH))
    original_height = int(cap.get(cv2.CAP_PROP_FRAME_HEIGHT))

    # 检查裁剪区域是否超出视频范围
    if x + w > original_width or y + h > original_height:
        raise ValueError("裁剪区域超出视频范围！")

    # 创建 VideoWriter 对象（输出裁剪后的视频）
    fourcc = cv2.VideoWriter_fourcc(*'mp4v')
    out = cv2.VideoWriter(output_path, fourcc, fps, (w, h))

    while cap.isOpened():
        ret, frame = cap.read()
        if not ret:
            break

        # 裁剪帧
        cropped_frame = frame[y:y + h, x:x + w]

        # 写入输出视频
        out.write(cropped_frame)

        # 显示实时效果（可选）
        # cv2.imshow("Cropped Video", cropped_frame)
        if cv2.waitKey(1) & 0xFF == ord('q'):
            break

    cap.release()
    out.release()
    cv2.destroyAllWindows()


def trim_video(input_path, output_path, start_time, end_time):
    """
    根据时间范围裁剪视频

    参数:
        input_path: 输入视频文件路径
        output_path: 输出视频文件路径
        start_time: 开始时间(秒)
        end_time: 结束时间(秒)
    """
    # 加载视频
    video = VideoFileClip(input_path)

    # 裁剪视频
    trimmed_video = video.subclipped(start_time, end_time)

    # 保存裁剪后的视频
    trimmed_video.write_videofile(output_path)

    # 关闭视频对象
    video.close()
    trimmed_video.close()


def cut_img(video_path, output_path):
    cap = cv2.VideoCapture(video_path)

    # 检查视频是否成功打开
    if not cap.isOpened():
        print("Error: Could not open video.")
        exit()

    # 读取第一帧
    time_ms = 5000  # 5000毫秒（5秒）
    cap.set(cv2.CAP_PROP_POS_MSEC, time_ms)
    ret, frame = cap.read()

    if ret:
        # 保存帧为图片
        cv2.imwrite(output_path, frame)
        print(f"Screenshot saved as {output_path}")
    else:
        print("Error: Could not read frame.")

    # 释放视频对象
    cap.release()


def halve_resolution(input_path, output_path):
    """
    将图片分辨率减半
    :param input_path: 输入图片路径
    :param output_path: 输出图片路径
    """
    with Image.open(input_path) as img:
        # 计算新尺寸（原尺寸的一半）
        new_size = (img.width // 3, img.height // 3)

        # 使用thumbnail方法保持宽高比
        img.thumbnail(new_size)

        # 保存图片
        img.save(output_path)
        print(f"图片已保存到 {output_path}，新尺寸: {img.size}")


def main():
    parser = argparse.ArgumentParser(description="示例脚本：接收参数")
    # 添加参数
    parser.add_argument("--input", "-i", type=str, required=True, help="输入文件路径")
    parser.add_argument("--output", "-o", type=str, help="输出文件路径")

    parser.add_argument("--start", type=str, help="开始时间")
    parser.add_argument("--end", type=str, help="结束时间")

    parser.add_argument("--verbose", "-v", action="store_true", help="启用详细模式")

    args = parser.parse_args()  # 解析参数

    print(f"输入文件: {args.input}")
    print(f"输出文件: {args.output}")
    print(f"开始时间: {args.start}")
    print(f"结束时间: {args.end}")

    dir_name = os.path.dirname(args.output)
    base_name = os.path.basename(args.output)
    file_name, file_ext = os.path.splitext(base_name)

    trimmed_path = dir_name + "/" + file_name + "_trimmed" + file_ext
    cut_path = dir_name + "/" + file_name + "_cutted" + file_ext
    final_path = dir_name + "/" + file_name + "_final" + file_ext
    img_path = dir_name + "/" + file_name + "_thumb" + ".png"

    trim_video(args.input, trimmed_path, args.start, args.end)
    cut_video(trimmed_path, cut_path)
    duration = int(float(args.end)) - int(float(args.start))
    trim_video(cut_path, final_path, 5, 20)
    cut_img(final_path, img_path)
    halve_resolution(img_path, img_path)
    os.rename(final_path, args.output)
    os.remove(cut_path)
    os.remove(trimmed_path)
    print("success!")


if __name__ == "__main__":
    main()
