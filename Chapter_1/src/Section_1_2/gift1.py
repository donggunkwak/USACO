"""
ID: donggun1
LANG: PYTHON3
TASK: gift1
"""
fin = open("gift1.in","r")
fout = open("gift1.out","w")

np = int(fin.readline())
people=[]
money=[]
for i in range(np):
    people.append(fin.readline()[:-1])
    money.append(0)
for i in range(np):
    nextperson = fin.readline()[:-1]
    line = fin.readline().split()
    moneygiven = int(line[0])
    amountppl = int(line[1])
    if amountppl==0:
        continue
    each = int(moneygiven/amountppl)
    moneylost = each*amountppl
    index = people.index(nextperson)
    money[index]-=moneylost
    for i in range(amountppl):
        receiver = fin.readline()[:-1]
        rindex = people.index(receiver)
        money[rindex]+=each
for i in range(np):
    fout.write(people[i]+" "+str(money[i])+"\n")
fin.close()
fout.close()



fin.close()
fout.close()
