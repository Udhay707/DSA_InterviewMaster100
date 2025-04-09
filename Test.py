import requests

def decode_secret_message(url):
    response = requests.get(url)
    lines = response.text.strip().splitlines()

    points = []
    max_x = 0
    max_y = 0

    for line in lines:
        parts = line.strip().split()
        if len(parts) < 3:
            continue  

        char = parts[0]
        try:
            x = int(parts[1])
            y = int(parts[2])
        except ValueError:
            continue 

        points.append((char, x, y))
        max_x = max(max_x, x)
        max_y = max(max_y, y)

    grid = [[' ' for _ in range(max_x + 1)] for _ in range(max_y + 1)]
    for char, x, y in points:
        grid[max_y - y][x] = char

    for row in grid:
        print(''.join(row))



decode_secret_message(r"https://docs.google.com/document/d/e/2PACX-1vQGUck9HIFCyezsrBSnmENk5ieJuYwpt7YHYEzeNJkIb9OSDdx-ov2nRNReKQyey-cwJOoEKUhLmN9z/pub")