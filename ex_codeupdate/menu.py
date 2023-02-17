from fileinput import filename
from tkinter import *
from tkinter.filedialog import *
from tkinter.simpledialog import *
from wand.image import *

#함수
def displayImage(img, width, height):
    global win, canvas, paper, photo, photo2, oriX, oriY

    win.geometry(str(width)+"x"+str(height))
    if canvas !=None:
        canvas.destroy()

    canvas=Canvas(win, width=width, height=height)
    paper=PhotoImage(width=width, height=height)
    canvas.create_image( (width/2, height/2), image=paper, state="normal")

    blob=img.make_blob(format='RGB')
    for i in range(0, width) :
        for k in range(0, height) :
            r=blob[(i*3*width)+(k*3)+0]
            g=blob[(i*3*width)+(k*3)+1]
            b=blob[(i*3*width)+(k*3)+2]
            paper.put("#%02x%02x%02x" %(r,g,b) , (k,i))
   
    canvas.pack()

def func_zoomin():
    global win, canvas, paper, photo, photo2, oriX, oriY
    scale = askinteger("확대배수", "확대할 배수를 입력하세요", minvalue=2, maxvalue=4)
    photo2 = photo.clone()
    photo2.resize(int(oriX*scale), int(oriY*scale))
    newX = photo2.width
    newY = photo2.height
    displayImage(photo2, newX, newY)
    
def func_zoomout():
    global win, canvas, paper, photo, photo2, oriX, oriY
    scale = askinteger("축소", "축소할 배수를 입력하세요", minvalue=2, maxvalue=4)
    photo2 = photo.clone()
    photo2.resize(int(oriX/scale), int(oriY/scale))
    newX = photo2.width
    newY = photo2.height
    displayImage(photo2, newX, newY)
    
def func_mirror1():
    global win, canvas, paper, photo, photo2, oriX, oriY
    photo2 = photo.clone()
    photo2.flip()
    newX = photo2.width
    newy = photo2.height
    displayImage(photo2, newX, newy)
    
    
def func_mirror2():
    global win, canvas, paper, photo, photo2, oriX, oriY
    photo2 = photo.clone()
    photo2.flop()
    newX = photo2.width
    newY = photo2.height
    displayImage(photo2, newX, newY)

    
def func_rotate():
    global win, canvas, paper, photo, photo2, oriX, oriY
    degree = askinteger("회전", "회전할 각도를 입력하세요", minvalue=0, maxvalue=360)
    photo2 = photo.clone()
    photo2.rotate(degree)
    newX = photo2.width
    newY = photo2.height
    displayImage(photo2, newX, newY)

def func_bright():
    global win, canvas, paper, photo, photo2, oriX, oriY    
    value=askinteger("밝게", "값을 입력하세요(100~200)", minvalue=0, maxvalue=200)
    photo2 = photo.clone()
    photo2.modulate(value, 100,100)
    newX = photo2.width
    newY = photo2.height
    displayImage(photo2, newX, newY)

def func_dark():
    global win, canvas, paper, photo, photo2, oriX, oriY    
    value=askinteger("어둡게", "값을 입력하세요(0~100)", minvalue=0, maxvalue=100)
    photo2 = photo.clone()
    photo2.modulate(value, 100, 100)
    newX = photo2.width
    newY = photo2.height
    displayImage(photo2, newX, newY)
    
def func_clear():
    global win, canvas, paper, photo, photo2, oriX, oriY    
    value=askinteger("선명하게", "값을 입력하세요(100~200)", minvalue=100, maxvalue=200)
    photo2 = photo.clone()
    photo2.modulate(100,value, 100)
    newX = photo2.width
    newY = photo2.height
    displayImage(photo2, newX, newY)
    
def func_unclear():
    global win, canvas, paper, photo, photo2, oriX, oriY    
    value=askinteger("탁하게", "값을 입력하세요(0~100)", minvalue=0, maxvalue=100)
    photo2 = photo.clone()
    photo2.modulate(100,value, 100)
    newX = photo2.width
    newY = photo2.height
    displayImage(photo2, newX, newY)

def func_bw():
    global win, canvas, paper, photo, photo2, oriX, oriY    
    photo2 = photo.clone()
    photo2.type="grayscale"
    newX = photo2.width
    newY = photo2.height
    displayImage(photo2, newX, newY)

def func_open():
    global win, canvas, paper, photo, photo2, oriX, oriY
    readFp=askopenfilename(parent=win, filetypes=(("모든 그림파일", "*.gif; *.jpg; *.jpeg; *.bmp; *.png; *.tif;"),("모든파일", "*.*")))
    photo=Image(filename=readFp)
    oriX=photo.width
    oriY=photo.height

    # filename=askopenfilename(parent=win, filetypes=(("GIF 파일", "*.gif"),("모든파일", "*.*")))
    # photo=PhotoImage(file=filename)
    # photo=Image.open(readFp)
    # photo2=photo.clone()
    # photo2=PhotoImage(filename=readFp)
    photo2 = photo.clone()
    newX=photo2.width
    newY=photo2.height
    displayImage(photo2, newX, newY)
    
    
    # pLable.configure(image=photo)
    # pLable.image=photo
    # tkinter.messagebox.showinfo("열기","열기메뉴를 선택함")


def func_save():
    global win, canvas, paper, photo, photo2, oriX, oriY

    if photo2 == None :
        return
    saveFp=asksaveasfile(parent=win, mode="w", defaultextension=".jpg", filetypes=(("JPG파일", "*.jpg; *.jpeg"),("모든파일", "*.*") ))
    # tkinter.messagebox.showinfo("저장","저장메뉴를 선택함")
    savePhoto=photo2.convert("jpg")
    savePhoto.save(filename=saveFp.name)
    
def func_exit():
    win.quit()
    win.destroy()


#변수
win, canvas, paper=None, None, None
photo, photo2=None,None
oriX, oriY=0,0

#메인 코드 부분 
win=Tk()
win.geometry("400x400")
win.title("미니포토샵(ver0.1)")

mainMenu = Menu(win)
win.config(menu=mainMenu)
photo=PhotoImage()
pLable=Label(win, image=photo)
pLable.pack(expand=1, anchor=CENTER)

fileMenu = Menu(mainMenu)
mainMenu.add_cascade(label="파일", menu=fileMenu)
fileMenu.add_command(label="파일 열기", command=func_open, accelerator="Ctrl+O")
fileMenu.add_separator()
fileMenu.add_command(label="파일 저장", command=func_save, accelerator="Ctrl+S")
fileMenu.add_separator()#메뉴안에 선
fileMenu.add_command(label="프로그램 종료", command=func_exit, accelerator="Ctrl+X")

imgMenu = Menu(mainMenu)
mainMenu.add_cascade(label="이미지 처리(1)", menu=imgMenu)
imgMenu.add_command(label="확대", command=func_zoomin)
imgMenu.add_separator()#메뉴안에 선
imgMenu.add_command(label="축소", command=func_zoomout)
imgMenu.add_separator()#메뉴안에 선
imgMenu.add_command(label="상하 반전", command=func_mirror1)
imgMenu.add_separator()#메뉴안에 선
imgMenu.add_command(label="좌우 반전", command=func_mirror2)
imgMenu.add_separator()#메뉴안에 선
imgMenu.add_command(label="회전", command=func_rotate)
imgMenu.add_separator()#메뉴안에 선


colorMenu = Menu(mainMenu)
mainMenu.add_cascade(label="이미지 처리(2)", menu=colorMenu)
colorMenu.add_command(label="밝게", command=func_bright)
colorMenu.add_separator()#메뉴안에 선
colorMenu.add_command(label="어둡게", command=func_dark)
colorMenu.add_separator()#메뉴안에 선
colorMenu.add_command(label="선명하게", command=func_clear)
colorMenu.add_separator()#메뉴안에 선
colorMenu.add_command(label="탁하게", command=func_unclear)
colorMenu.add_separator()#메뉴안에 선
colorMenu.add_command(label="흑백이미지", command=func_bw)




win.mainloop()

# 라이브러리 설치시 
# python get -pip.py→ 이렇게 하면 깔림 
#ver0.1 0427 실행확인! 