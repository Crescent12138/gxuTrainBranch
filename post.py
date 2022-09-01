import xlrd
import pymysql
work = xlrd.open_workbook("66.xls")
book = work.sheet_by_index(0)

connect = pymysql.connect(host='rm-bp1e5v7r58se890h4go.mysql.rds.aliyuncs.com',   # 本地数据库
                          user='maomao',
                          password='MaoMao114514',
                          db='gxutrainbranch',
                        autocommit =True,
                          charset='utf8') #服务器名,账户,密码，数据库名称
cur = connect.cursor()
print(cur)
num = 10001
f = 1

for i in  book:
    if(f):
        f = 0
        continue
    print(i)
    parm =(int(i[0].value),"万健南",0,"计科201","计科",2.0)
    print(parm)
    cur.execute("insert ignore into studentInformation (studentId ,studentName,studentSex,studentClass,studentCourse,studentScore) values(%s,%s,%s,%s,%s,%s)",parm)
    cur.execute("insert  ignore into activity (activityId,activityType,activityName,actionType,activityScore)values (%r,%s,%s,%s,%r)",(num,str(i[1].value),i[2].value,i[3].value,i[4].value))

    cur.execute("insert  into studentMeasurePoint (studentId,activityId,activityScore)values(%r,%r,%r) ",(int(i[0].value),num,i[4].value))
    num+= 1

cur.close()