class Solution:
    def repairCars(self, ranks: List[int], cars: int) -> int:

        def can_service_all_car_in_given_time(ranks, time_limit, target):
            num_of_cars_serviced = 0

            for rank in ranks:
                num_of_cars_serviced += floor(sqrt(time_limit / rank))
                if num_of_cars_serviced >= target:
                    return True
            return False

        low = 0
        high = 100 * (cars**2)

        while low <= high:
            mid = (low + high) // 2

            if can_service_all_car_in_given_time(ranks, mid, cars):
                high = mid - 1
            else:
                low = mid + 1

        return low
