class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        size=len(board)
        rows=[set() for _ in range(size)]
        cols=[set() for _ in range(size)]
        boxes=[set() for _ in range(size)]

        for i in range(len(board[0])):
            for j in range(len(board)):
                value=board[i][j]
                if value=='.':
                    continue

                box_id=((i//3)*3) + (j//3)

                if value in rows[i] or value in cols[j] or value in boxes[box_id]:
                    return False
                
                rows[i].add(value)
                cols[j].add(value)
                boxes[box_id].add(value)

        return True