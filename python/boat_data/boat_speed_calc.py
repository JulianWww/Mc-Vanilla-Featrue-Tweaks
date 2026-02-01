from math import log
from numpy import e, linspace
import matplotlib.pyplot as plt

def get_params(max_speed, ttmax):
    fric = -log(0.1)/(ttmax*20)
    acc = max_speed * fric / 20
    back_acc = 0.05 / 0.9 * fric
    return 1-fric, acc, back_acc


types = {
    "boat": {
        "max_speed": 8,
        "tt90": 1.1512925
    },
    "sail_boat": {
        "max_speed": 10,
        "tt90": 3.5
    },
    "medium_boat": {
        "max_speed": 15,
        "tt90": 10
    },
    "large_boat": {
        "max_speed": 20,
        "tt90": 20
    }
}

for boat_type, data in types.items():
    fric, acc, back_acc = get_params(data["max_speed"], data["tt90"])
    data["acc"] = acc
    data["fric"] = fric
    data["back_acc"] = back_acc
    print(f"{boat_type} with acc: {acc}, fric {fric}, back_acc {back_acc}")



x = linspace(0, 25, 50)

def f(x, acc, fric):
    return 20*acc / (1-fric) * (1 - e**(-(1-fric)*20*x))

for boat_type, data in types.items():
    y = f(x, data["acc"], data["fric"])
    plt.plot(x, y)

plt.legend(types.keys())
plt.xlabel("time / s")
plt.ylabel("speed in blocks per second")

plt.savefig("boat_speed.png")
plt.show()
