#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Script chuyển đổi file Markdown sang HTML để mở bằng Microsoft Word
"""

import re
import html

def markdown_to_html(md_content):
    """Chuyển đổi markdown sang HTML với định dạng phù hợp cho Word"""
    
    html_content = """<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="ProgId" content="Word.Document">
    <meta name="Generator" content="Microsoft Word">
    <meta name="Originator" content="Microsoft Word">
    <title>Báo Cáo Bài Tập Lớn - Hệ Thống Quản Lý Trại Thú Cưng</title>
    <style>
        @page {
            size: A4;
            margin: 2.5cm 2cm 2.5cm 2cm;
        }
        body {
            font-family: "Times New Roman", serif;
            font-size: 12pt;
            line-height: 1.6;
            text-align: justify;
        }
        h1 {
            font-size: 18pt;
            font-weight: bold;
            text-align: center;
            margin-top: 20pt;
            margin-bottom: 12pt;
            page-break-after: avoid;
        }
        h2 {
            font-size: 16pt;
            font-weight: bold;
            text-align: center;
            margin-top: 16pt;
            margin-bottom: 10pt;
            page-break-after: avoid;
        }
        h3 {
            font-size: 14pt;
            font-weight: bold;
            text-align: center;
            margin-top: 14pt;
            margin-bottom: 8pt;
            page-break-after: avoid;
        }
        h4 {
            font-size: 13pt;
            font-weight: bold;
            margin-top: 12pt;
            margin-bottom: 6pt;
            page-break-after: avoid;
        }
        h5 {
            font-size: 12pt;
            font-weight: bold;
            margin-top: 10pt;
            margin-bottom: 4pt;
            page-break-after: avoid;
        }
        h6 {
            font-size: 11pt;
            font-weight: bold;
            margin-top: 8pt;
            margin-bottom: 4pt;
            page-break-after: avoid;
        }
        p {
            margin-top: 6pt;
            margin-bottom: 6pt;
            text-indent: 1.27cm;
        }
        ul, ol {
            margin-top: 6pt;
            margin-bottom: 6pt;
            padding-left: 1.5cm;
        }
        li {
            margin-top: 3pt;
            margin-bottom: 3pt;
        }
        strong {
            font-weight: bold;
        }
        em {
            font-style: italic;
        }
        code {
            font-family: "Courier New", monospace;
            font-size: 10pt;
            background-color: #f5f5f5;
            padding: 2pt 4pt;
        }
        pre {
            font-family: "Courier New", monospace;
            font-size: 10pt;
            background-color: #f5f5f5;
            border: 1px solid #ddd;
            padding: 10pt;
            margin: 10pt 0;
            white-space: pre-wrap;
            page-break-inside: avoid;
        }
        hr {
            border: none;
            border-top: 1px solid #000;
            margin: 20pt 0;
        }
        table {
            border-collapse: collapse;
            width: 100%;
            margin: 10pt 0;
        }
        th, td {
            border: 1px solid #000;
            padding: 5pt;
            text-align: left;
        }
        th {
            background-color: #f0f0f0;
            font-weight: bold;
        }
        .no-indent {
            text-indent: 0;
        }
        .center {
            text-align: center;
        }
    </style>
</head>
<body>
"""
    
    lines = md_content.split('\n')
    in_code_block = False
    code_block_content = []
    i = 0
    
    while i < len(lines):
        line = lines[i]
        
        # Xử lý code block
        if line.strip().startswith('```'):
            if in_code_block:
                # Kết thúc code block
                html_content += '<pre>' + html.escape('\n'.join(code_block_content)) + '</pre>\n'
                code_block_content = []
                in_code_block = False
            else:
                # Bắt đầu code block
                in_code_block = True
            i += 1
            continue
        
        if in_code_block:
            code_block_content.append(line)
            i += 1
            continue
        
        # Xử lý heading
        if line.startswith('# '):
            html_content += '<h1>' + html.escape(line[2:].strip()) + '</h1>\n'
        elif line.startswith('## '):
            html_content += '<h2>' + html.escape(line[3:].strip()) + '</h2>\n'
        elif line.startswith('### '):
            html_content += '<h3>' + html.escape(line[4:].strip()) + '</h3>\n'
        elif line.startswith('#### '):
            html_content += '<h4>' + html.escape(line[5:].strip()) + '</h4>\n'
        elif line.startswith('##### '):
            html_content += '<h5>' + html.escape(line[6:].strip()) + '</h5>\n'
        elif line.startswith('###### '):
            html_content += '<h6>' + html.escape(line[7:].strip()) + '</h6>\n'
        # Xử lý horizontal rule
        elif line.strip() == '---':
            html_content += '<hr>\n'
        # Xử lý danh sách
        elif line.strip().startswith('- ') or line.strip().startswith('* '):
            if i == 0 or not (lines[i-1].strip().startswith('- ') or lines[i-1].strip().startswith('* ')):
                html_content += '<ul>\n'
            content = line.strip()[2:].strip()
            # Xử lý bold và italic trong list item
            content = re.sub(r'\*\*(.+?)\*\*', r'<strong>\1</strong>', content)
            content = re.sub(r'\*(.+?)\*', r'<em>\1</em>', content)
            html_content += '<li>' + html.escape(content) + '</li>\n'
            if i == len(lines) - 1 or not (lines[i+1].strip().startswith('- ') or lines[i+1].strip().startswith('* ')):
                html_content += '</ul>\n'
        elif re.match(r'^\d+\.\s', line.strip()):
            if i == 0 or not re.match(r'^\d+\.\s', lines[i-1].strip()):
                html_content += '<ol>\n'
            content = re.sub(r'^\d+\.\s', '', line.strip())
            content = re.sub(r'\*\*(.+?)\*\*', r'<strong>\1</strong>', content)
            content = re.sub(r'\*(.+?)\*', r'<em>\1</em>', content)
            html_content += '<li>' + html.escape(content) + '</li>\n'
            if i == len(lines) - 1 or not re.match(r'^\d+\.\s', lines[i+1].strip()):
                html_content += '</ol>\n'
        # Xử lý paragraph
        elif line.strip():
            # Xử lý bold và italic
            content = line.strip()
            # Xử lý inline code trước
            content = re.sub(r'`([^`]+)`', r'<code>\1</code>', content)
            # Xử lý bold
            content = re.sub(r'\*\*([^*]+)\*\*', r'<strong>\1</strong>', content)
            # Xử lý italic (sau khi đã xử lý bold)
            content = re.sub(r'(?<!\*)\*([^*]+)\*(?!\*)', r'<em>\1</em>', content)
            # Xử lý links [text](url)
            content = re.sub(r'\[([^\]]+)\]\([^\)]+\)', r'\1', content)
            
            # Escape HTML nhưng giữ lại các tag đã tạo
            # Tách các tag HTML ra trước khi escape
            parts = re.split(r'(<[^>]+>)', content)
            escaped_parts = []
            for part in parts:
                if part.startswith('<') and part.endswith('>'):
                    escaped_parts.append(part)
                else:
                    escaped_parts.append(html.escape(part))
            content = ''.join(escaped_parts)
            
            # Kiểm tra nếu là dòng đặc biệt (không indent) - thường là label
            if re.match(r'^\*\*[^*]+\*\*:\s', line.strip()) or re.match(r'^[A-Z][^:]+:\s', line.strip()):
                html_content += '<p class="no-indent">' + content + '</p>\n'
            else:
                html_content += '<p>' + content + '</p>\n'
        else:
            html_content += '<p>&nbsp;</p>\n'
        
        i += 1
    
    html_content += """
</body>
</html>
"""
    
    return html_content

def main():
    # Đọc file markdown
    with open('BAI_TAP_LON.md', 'r', encoding='utf-8') as f:
        md_content = f.read()
    
    # Chuyển đổi sang HTML
    html_content = markdown_to_html(md_content)
    
    # Ghi file HTML
    with open('BAI_TAP_LON.html', 'w', encoding='utf-8') as f:
        f.write(html_content)
    
    print("✅ Đã tạo file BAI_TAP_LON.html")
    print("\nHướng dẫn:")
    print("1. Mở file BAI_TAP_LON.html bằng Microsoft Word")
    print("2. Trong Word: File → Save As → Chọn định dạng .doc hoặc .docx")
    print("3. Hoặc: File → Export → Change File Type → Word Document")

if __name__ == '__main__':
    main()

