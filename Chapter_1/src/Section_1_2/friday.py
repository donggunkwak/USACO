"""
ID: donggun1
LANG: PYTHON3
TASK: friday
"""
import datetime
fin = open("friday.in","r")
fout = open("friday.out","w")

n = int(fin.readline()[:-1])
days = [0,0,0,0,0,0,0]
for y in range(1900,1900+n):
    for m in range(1,13):
        x = datetime.datetime(y,m,13)
        days[int(x.strftime("%w"))]+=1
ans = str(days[6]) +" "
for i in range(0,6):
    ans += str(days[i])+" "
fout.write(ans[:-1]+"\n")

"""
times = [0,0,0,0,0,0,0]
# 0-saturday,1-sunday,2- monday, etc
day = 2
for y in range(1900,1900+n):
    for m in range(1,13):
        if m==9 or m==4 or m==6 or m==11:
            for d in range(1,31):
                if d==13:
                    times[day]+=1
                day+=1
                if day>=7:
                    day=0
        elif m==2:
            if y%400==0:
                for d in range(1,30):
                    if d==13:
                        times[day]+=1
                    day+=1
                    if day>=7:
                        day=0
            elif y%4==0 and y%100!=0:
                for d in range(1,30):
                    if d==13:
                        times[day]+=1
                    day+=1
                    if day>=7:
                        day=0
            else:
                for d in range(1,29):
                    if d==13:
                        times[day]+=1
                    day+=1
                    if day>=7:
                        day=0
        else:
            for d in range(1,32):
                if d==13:
                    times[day]+=1
                day+=1
                if day>=7:
                    day=0
ans =""
for i in times:
    ans+=str(i)+" "
fout.write(ans[:-1]+"\n")
"""
fin.close()
fout.close()
