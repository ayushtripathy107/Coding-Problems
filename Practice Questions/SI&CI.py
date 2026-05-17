#Simple Interest
p = float(input("Principal: "))
r = float(input("Rate: "))
t = float(input("Time: "))
si = (p * r * t) / 100
total_si = p + si
print(f"SI: {si}")
print(f"Total: {total_si}\n")

#Compound Interest
p2 = float(input("Principal: "))
r2 = float(input("Rate: "))
t2 = float(input("Time: "))
total_ci = p2 * ((1 + r2 / 100) ** t2)
ci = total_ci - p2
print(f"CI: {ci}")
print(f"Total: {total_ci}")
