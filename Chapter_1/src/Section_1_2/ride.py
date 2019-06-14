"""
ID: donggun1
LANG: PYTHON3
TASK: ride
"""
def convert(s):
    res = 1
    for i in range(len(s)):
        res *= ord(s[i])-ord('A')+1
    return res%47

fin = open("ride.in", "r")
fout = open("ride.out", "w")

s1=fin.readline()
s2=fin.readline()

if convert(s1)==convert(s2):
    fout.write("GO\n")
else:
    fout.write("STAY\n")
fin.close()
fout.close()
