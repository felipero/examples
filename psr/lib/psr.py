prods1,prods2 = [1],[1]
 
for p in [2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73]:
    prods1 += [x*p for x in prods1]
 
for p in [79,83,89,97,101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,179,181]:
    prods2 += [x*p for x in prods2]

#print prods1

#print prods2
 
prods1.sort()
prods2.sort(reverse=True)
target = (prods1[-1]*prods2[0])**0.5
l1,l2 = len(prods1),len(prods2)

print target
#print l2
 
i=j=best=0
while i<l1 and j<l2:
    current = prods1[i]*prods2[j]
    if current>target:
        j+=1
    elif current<target:
        if current>best: best=current
        i+=1
 
print best%(10**16)
