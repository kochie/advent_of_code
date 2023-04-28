

if __name__ == "__main__":
    with open("input.txt") as f:
        data = f.read()

    data = data.splitlines()
    m1 = 0
    m2 = 0
    m3 = 0
    x = 0
    for line in data:
        if line == "":
            if x > m1:
                m3 = m2
                m2 = m1
                m1 = x
            elif x > m2:
                m3 = m2
                m2 = x
            elif x > m3:
                m3 = x
            x = 0
        else:
            x += int(line)

    print(m1 + m2 + m3)
